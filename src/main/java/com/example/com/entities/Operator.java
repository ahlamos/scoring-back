package com.example.com.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public  enum Operator
{

    NOT_EQUAL_TO("Not equal to", "!=", (new ArrayList<Class>()
    {
        {
            add(String.class);
            add(Double.class);
            add(Float.class);
            add(Integer.class);
            add(Short.class);
            add(Long.class);
            add(Date.class);
        }
    })),

    EQUAL_TO("Equal to", "==", (new ArrayList<Class>()
    {
        {
            add(String.class);
            add(Double.class);
            add(Double.class);
            add(Float.class);
            add(Integer.class);
            add(Short.class);
            add(Long.class);
            add(Date.class);
        }
    })),

    CONTAINS("Contains this", "?", (new ArrayList<Class>()
    {
        {
            add(String.class);
        }
    })),

    GREATER_THAN("Greater than", ">", (new ArrayList<Class>()
    {
        {
            add(String.class);
            add(Double.class);
            add(Double.class);
            add(Float.class);
            add(Integer.class);
            add(Short.class);
            add(Long.class);
            add(Date.class);
        }
    })),

    LESS_THAN("Less than", "<", (new ArrayList<Class>()
    {
        {
            add(String.class);
            add(Double.class);
            add(Double.class);
            add(Float.class);
            add(Integer.class);
            add(Short.class);
            add(Long.class);
            add(Date.class);
        }
    })),
    /**
     * The value is greater or equal to
     */
    GREATER_THAN_OR_EQUAL_TO("Greater or equal to", ">=", (new ArrayList<Class>()
    {
        {
            add(String.class);
            add(Double.class);
            add(Double.class);
            add(Float.class);
            add(Integer.class);
            add(Short.class);
            add(Long.class);
            add(Date.class);
        }
    })),

    LESS_THAN_OR_EQUAL_TO("Less or equal to", "<=", (new ArrayList<Class>()
    {
        {
            add(String.class);
            add(Double.class);
            add(Double.class);
            add(Float.class);
            add(Integer.class);
            add(Short.class);
            add(Long.class);
            add(Date.class);
        }
    }));

    private final String description;

    private  String operation;
    private  List<Class> acceptables;

    private Operator(String description, String operation, List<Class> acceptables)
    {
        this.description = description;
        this.operation = operation;
        this.acceptables = acceptables;
    }
    private Operator(String description)
    {
        this.description = description;

    }

    @Override
    public String toString()
    {
        StringBuilder me = new StringBuilder("[" + this.getClass().getName());
        me.append(" | name = ");
        me.append(name());
        me.append(" | description = ");
        me.append(description);
        me.append(" | operation = ");
        me.append(operation);
        me.append(" | acceptables = ");
        me.append(Arrays.toString(acceptables.toArray()));
        me.append("]");

        return me.toString();
    }

    public String getDescription()
    {
        return description;
    }

    public String getOperation()
    {
        return operation;
    }
    public boolean isComparable(Class clazz)
    {
        for (Class accept : acceptables)
        {
            if (accept.equals(clazz))
            {
                return true;
            }
        }

        return false;
    }

    public static Operator fromDescription(String description) throws EnumConstantNotPresentException
    {
        for (Operator operator : Operator.values())
        {
            if (operator.getDescription().equals(description))
            {
                return operator;
            }
        }

        throw new EnumConstantNotPresentException(Operator.class, "? (" + description + ")");
    }
}
