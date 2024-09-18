import java.util.ArrayList;

public class complaintlist {

    private static ArrayList<complaint> complaintlist = new ArrayList<>();

    
    public static void displaycomplaints(int filter) {

        if (complaintlist.isEmpty()) {
            System.out.println("No complaint found");
            return;
        }
        for (complaint complaint : complaintlist) {
            if (filter == 0 || (filter ==1 && complaint.getstatus().equals("pending")) || (filter ==2 && complaint.getstatus().equals("resolved"))) {
                System.out.printf("Student: %s,Complaint ID: %d, Matter: %s, Status: %s\n", complaint.getstud(),
                        complaint.getcode(), complaint.getmatter(),
                        complaint.getstatus());
            }      
            
        }
    }

    public static ArrayList<complaint> getlist() {
        return complaintlist;
    }

    public static void addcomplaint(complaint comp) {
        complaintlist.add(comp);
    }



}
