public class Train {
    private String name, product, origin, destination;
    private int weight, miles;

    public Train(String n, String p, String o, String d, int w, int m)
    {
        name = n;
        product = p;
        origin = o;
        destination = d;
        weight = w;
        miles = m;
    } // end constructor

    public Train(String n, String d)
    {
        this(n, "", "", d, 0, 0);
    }

    public String toString()
    {
        if(name.substring(0,3).equals("CAR"))
            return name + " containing " + product + " weighing " + weight + "lbs.";
        else
            return name + " leaving for " + destination + " with the following cars:";
    }

    public boolean isEngine()
    {
        return name.substring(0,3).equals("ENG");
    }

    public String getName()
    {
        return name;
    }

    public String getOrigin()
    {
        return origin;
    }

    public String getDestination()
    {
        return destination;
    }

    public String getProduct()
    {
        return product;
    }

    public int getMiles()
    {
        return miles;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setMiles()
    {
        miles = 100;
    }
}
