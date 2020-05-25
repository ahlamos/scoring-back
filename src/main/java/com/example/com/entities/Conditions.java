
package com.example.com.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Conditions implements Serializable
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String property;
  private String value;
  public String operation;

	public Conditions()
	{
	}
	public Conditions(String property, String operation, String value)
	{
		this.property = property;
		this.operation = operation;
		this.value = value;
	}

	public String buildExpression() throws Exception
	{
		StringBuilder drl = new StringBuilder();
		
		if (isDate(value) )
		{
			drl.append(expressionForDateValue());
		}
		else if (isInteger(value) || isDouble(value))
		{
			drl.append(expressionForNumberValue());
		}
		else
		{
			drl.append(expressionForStringValue());
		}

		return drl.toString();
	}

	private String expressionForStringValue() throws IllegalArgumentException
	{
		StringBuilder drl = new StringBuilder();

		Operator operator= Operator.fromDescription(operation);
		if (operator.isComparable(String.class))
		{
			if (operator.equals(Operator.CONTAINS))
			{
				drl.append(property).append(".toUpperCase().contains(\"").append(((String)value).toUpperCase()).append("\")");
			}
			else
			{
				drl.append(property).append(" ").append(operator.getOperation()).append(" ").append("\"").append(value).append("\"");
			}
		}
		else
		{
			throw new IllegalArgumentException("Is not possible to use the operator " + operator.getDescription() + " to a " + value.getClass().getSimpleName() + " object.");
		}
		
		return drl.toString();
	}
	private String expressionForNumberValue() throws IllegalArgumentException,Exception
	{
		StringBuilder drl = new StringBuilder();
		Operator operator= Operator.fromDescription(operation);

		if ((operator.isComparable(Short.class)) || (operator.isComparable(Integer.class)) || (operator.isComparable(Long.class)) 
						|| (operator.isComparable(Double.class)) || (operator.isComparable(Float.class)))
		{
			drl.append(property).append(" ").append(operator.getOperation()).append(" ").append(Double.parseDouble(value));
		}
		else
		{
			throw new IllegalArgumentException("Is not possible to use the operator " + operator.getDescription() + " to a " + value.getClass().getSimpleName() + " object.");
		}
		
		return drl.toString();
	}

	private String expressionForDateValue() throws IllegalArgumentException, Exception
	{
		StringBuilder drl = new StringBuilder();
		Operator operator= Operator.fromDescription(operation);

		if (operator.isComparable(Date.class))
		{
			drl.append(property).append(" ").append(operator.getOperation()).append(" (new SimpleDateFormat(\"dd/MM/yyyy HH:mm:ss\")).parse(\"" + (new SimpleDateFormat("dd/MM/yyyy HH:mm:ss")).format( new SimpleDateFormat("dd/MM/yyyy").parse(value) ) + "\")");
		}
		else
		{
			throw new IllegalArgumentException("Is not possible to use the operator " + operator.getDescription() + " to a " + value.getClass().getSimpleName() + " object.");
		}

		return drl.toString();
	}
	public static boolean isDate(String value){
		SimpleDateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date date = d.parse(value);
			return true;
		} catch (ParseException ex) {
			return false;
		}


	}
	public static boolean isInteger(String value){
		try {
			int i = Integer.parseInt(value);
			return true;
		}
		catch (Exception e) {
			return false;
		}


	}
	public static boolean isDouble(String value) {
		try {
			double i=Double.parseDouble(value);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}


	public String getProperty()
  {
    return property;
  }

  public String getValue()
  {
    return value;
  }
  

  
  public void setProperty(String property)
  {
    this.property = property;
  }
  
  public void setValue(String value)
  {
    this.value = value;
  }

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
