package com.example.com.entities;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Rule
{

    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private  String name;
  @OneToMany(cascade = CascadeType.ALL)
  @RestResource(exported = false)
  private List<Conditions> conditions = new ArrayList<Conditions>();

  private String action;
  public Rule(String name)
  {
    this.name = name;
  }

    public Rule() {
    }

    public enum Attribute
	{

		RULE_NAME("name"),
		DATA_OBJECT("object"),
		CONDITIONAL("conditional"),
		ACTION("action");
		private final String name;
		private Attribute(String name)
		{
			this.name = name;
		}
		
		@Override
		public String toString()
		{
			return name;
		}
	}


  @Override
  public String toString()
  {
    StringBuilder me = new StringBuilder("[" + this.getClass().getName());
    me.append(" | name = ");
    me.append(name);
    me.append(" | object = ");
    me.append(" | conditions = ");
    me.append(((conditions == null) ? "null" : conditions.size()));
    me.append(" | action = ");
    me.append(action);
    me.append("]");
    
    return me.toString();
  }

  public String conditionAsDRL() throws Exception {
    if ((conditions == null) || (conditions.isEmpty()))
    {
      throw new IllegalStateException("You must declare at least one condition to be evaluated.");
    }
    
    StringBuilder drl = new StringBuilder();
    for (int i = 0; i < conditions.size(); i++)
    {
      Conditions conditions = this.conditions.get(i);
			drl.append("(");
			drl.append(conditions.buildExpression());
			drl.append(")");
      if ((i + 1) < this.conditions.size())
      {
        drl.append(" && ");
      }
    }
		
    return drl.toString();
  }
	

	public Map<String, Object> asMap() throws Exception
	{
		if ((name == null) ||  (action == null))
		{
			throw new IllegalArgumentException("The rule has no name, object to be evaluated or action to be accomplished.");
		}
		
		Map<String, Object> attributes = new HashMap<String, Object>();
    attributes.put(Rule.Attribute.RULE_NAME.toString(), name);
    attributes.put(Rule.Attribute.CONDITIONAL.toString(), conditionAsDRL());
    attributes.put(Rule.Attribute.ACTION.toString(), action);
		
		return attributes;
	}

	public Conditions addCondition(String property, String description, String value)
	{
		Conditions conditions = new Conditions(property, description, value);
		this.conditions.add(conditions);
		
		return conditions;
	}
	
  public String getName()
  {
    return name;
  }


  public List<Conditions> getConditions()
  {
    return conditions;
  }
	
	public Conditions getCondition()
	{
		if ((conditions == null) || (conditions.isEmpty()))
		{
			return null;
		}
		else
		{
			return conditions.get(0);
		}
	}
  
  public void setConditions(List<Conditions> conditions)
  {
    this.conditions = conditions;
  }
  
	public void setCondition(Conditions conditions)
  {
    this.conditions = new ArrayList<Conditions>();
    this.conditions.add(conditions);
  }

  public String getAction()
  {
    return action;
  }
  

  public void setAction(String action)
  {
    this.action = action;
  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
