import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Control {
    Travelers T;
    Flights F;
    private Travelers[] alltravelers;
    private Flights[] allflights;
    private int numtravelers;
    private int max;
    private int numflight;


    public Control() throws FileNotFoundException {
         max=10;
        alltravelers = new Travelers[max];
        allflights = new Flights[4];
        numtravelers = 0;
        numflight=0;
        readTravelersFiles();
        readFlightsFiles();
    }


    public boolean addtravelers(int numpassport, String fullname, int numphone, String country) {
        if (numtravelers< max)
        {
            Travelers t = new Travelers( numpassport,fullname,numphone,country);
            alltravelers[numtravelers] = t;
            numtravelers++;
            Travelers.counter++;
            return true;
        }
        else return false;
    }

    public Travelers[] viewthetravelers() {
        return alltravelers;
    }

    public Travelers searchtravelers(int numpassport ) {
        boolean found = false;
        int i = 0;
        while (!found && i < alltravelers.length)
        {
            if (alltravelers[i] != null)
            {
                if (alltravelers[i].getNumpassport() == numpassport)
                    found = true;

            }
            else i++;
        }
        if (i < alltravelers.length)
            return alltravelers[i];
        else return null;
    }

    public int searchfortravelerindex(int numpassport)
    {
        boolean found = false;
        int i = 0;
        while (!found && i < alltravelers.length)
        {
            if (alltravelers[i] != null)
            {
                if (alltravelers[i].getNumpassport() == numpassport)
                   found= true;
            }
            else i++;
        }
        if (i < alltravelers.length)
            return i;
        else return -1;
    }

    public boolean deletetraveler(int numpassport)
    {
        int index=searchfortravelerindex( numpassport);
        if (index!=-1)
        {
            alltravelers[index]=null;
            return true;
        }
        else return false;
    }
    public boolean edittravelers(int id, String newName, int p, String c)
    {
        int index=searchfortravelerindex( id);
        if (index!=-1)
        {
            alltravelers[index].setNumpassport(id);
            alltravelers[index].setFullname(newName);
            alltravelers[index].setNumphone(p);
            alltravelers[index].setCountry(c);
            return true;
        }
        else return false;
    }
    public boolean chackFordupliceted(Travelers t)
    {
        for (int i = 0; i <numtravelers ; i++) {
            if (alltravelers[i].equals(t))
                return true;
        }
        return false;
    }


    public boolean addflight(String from, String to, String dep_date, String arv_date, int numtravelers, int travelersprice, String c)
    {
        if (numflight < allflights.length) {
            Flights f = new Flights(from,to,dep_date,arv_date,numtravelers,travelersprice);
            allflights[numflight] = f;
            numflight++;
            return true;
        } else return false;
    }
    public Flights[] viewtheflights() {
        return allflights;
    }

    public Flights searchflight(int id ) {
        boolean found = false;
        int i = 0;
        while (!found && i < allflights.length)
        {
            if (allflights[i] != null)
            {
                if (allflights[i].getNumTrip() == id)
                    found = true;
                else i++;
            }
            else i++;
        }
        if (i < allflights.length)
            return allflights[i];
        else return null;
    }

    public int searchforflightindex(int NumTrip)
    {
        boolean found = false;
        int i = 0;
        while (!found && i < allflights.length)
        {
            if (allflights[i] != null)
            {
                if (allflights[i].getNumTrip() == NumTrip)
                    found = true;
                return allflights[i].getNumTrip();
            }
            else i++;
        }
        if (i < allflights.length)
            return allflights[i].getNumTrip();
        else return -1;
    }
    public boolean deleteflight(int NumTrip)
    {
        int index=searchforflightindex(NumTrip);
        if (index!=-1)
        {
            allflights[index]=null;
            return true;
        }
        else return false;
    }
    public boolean editflight(String from, String to, String dep_date, String arv_date, int NumpTrip, int travelersprice)
    {
        int index=searchforflightindex(NumpTrip);
        if (index!=-1)
        {
            allflights[index].setFrom(from);
            allflights[index].setFrom(to);
            allflights[index].setFrom(dep_date);
            allflights[index].setFrom(arv_date);
            allflights[index].setFrom(String.valueOf(numtravelers));
            allflights[index].setFrom(String.valueOf(travelersprice));
            return true;
        }
        else return false;
    }
    public void readTravelersFiles() throws FileNotFoundException {
        Scanner in=new Scanner(new File("/Users/abdo/Documents/Java/Travelers.txt"));
        while (in.hasNext())
        {
            int i=in.nextInt();
            String f=in.next();
            int l=in.nextInt();
            String y=in.next();
            addtravelers(i,f,l,y);
        }
        in.close();
    }
    public void writeTravelers() throws FileNotFoundException {
        PrintWriter writer=new PrintWriter("/Users/abdo/Documents/Java/Travelers.txt");
        int i=0;
        while (i<numtravelers)
        {
            writer.write(alltravelers[i].getNumpassport()+" "+alltravelers[i].getFullname()+" "+alltravelers[i].getNumphone()+" "+
                    alltravelers[i].getCountry()+"\n");
            i++;
        }
        writer.close();
    }
    public void readFlightsFiles() throws FileNotFoundException {
        Scanner in=new Scanner(new File("/Users/abdo/Documents/Javaa/Flights.txt"));
        while (in.hasNext())
        {
          String f=in.next();
            String t=in.next();
            String a=in.next();
            String d=in.next();
            int n=in.nextInt();
            int p=in.nextInt();
            String c=in.next();
            addflight(f,t,a,d,n,p,c);
        }
        in.close();
    }
    public void writeFlightsFile() throws FileNotFoundException {
        PrintWriter writer=new PrintWriter("/Users/abdo/Documents/Javaa/Flights.txt");
        int i=0;
        while (i<numflight)
        {
            writer.write(allflights[i].getFrom()+" "+allflights[i].getTo()+" "+allflights[i].getArv_date()+" "+allflights[i].getDep_date()+" "+allflights[i].getNumTrip()+" "+
                    allflights[i].getTravelersprice()+"\n");
            i++;
        }
        writer.close();
    }
    public String receipt(int numpassport, String fullname, int numphone, String country,String from, String to, String dep_date, String arv_date, int numtravelers, int travelersprice)
    {
        Travelers t=new Travelers(numpassport,fullname,numphone,country);
        Flights f=new Flights(from,to,dep_date,arv_date,numtravelers,travelersprice);
        return T.toString() +F.toString();



    }
    public Travelers[] viewRecepit2() {
        Travelers[] f = viewthetravelers();
        System.out.println("Numpassport   Fullname   Numphone   Country");
        for (int i = 0; i < f.length; i++) {
            if (f[i] != null)
         /*     System.out.println(f[i].getNumpassport()+"\t"+f[i].getFullname()
                        +"\t"+f[i].getNumphone()+"\t"+f[i].getCountry());*/
                f[i].toString();
            return new Travelers[]{alltravelers[i]};
        }
        return alltravelers;
    }
    public Flights[] viewRecepit() {
        Travelers[] f = viewthetravelers();
        System.out.println("From   To   Dep_date   Arv_date   NumTrip    Price of receipt");
        for (int i = 0; i < f.length; i++) {
            if (f[i] != null)
         /*     System.out.println(f[i].getNumpassport()+"\t"+f[i].getFullname()
                        +"\t"+f[i].getNumphone()+"\t"+f[i].getCountry());*/
                f[i].toString();
            return new Flights[]{allflights[i]};
        }
        return allflights;
    }


}
