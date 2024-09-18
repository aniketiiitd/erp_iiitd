public class mkuser {

    public static student mkstud() {
        String id = takeinp.strinp("Enter student ID: ");
        if (usermap.stud_exist(id)) {
            System.out.println("User already exists!");
            String pass = takeinp.strinp("Enter password: ");
            while (!pass.equals(usermap.getpass(id))) {
                pass = takeinp.strinp("Wrong password, enter again: ");
            }
            return usermap.getstd(id);
        }

        String password = takeinp.strinp("Create a password: ");
        student stud = new student(id, password);
        usermap.addstud(id, stud);
        usermap.addpass(id, password);
        userlist.addstdlist(stud);
        System.out.println("Student account created!");
        return stud;
    }

    public static professor mkprof() {
        String id = takeinp.strinp("Enter professor ID: ");
        if (usermap.prof_exist(id)) {
            System.out.println("User already exists!");
            String pass = takeinp.strinp("Enter password: ");
            while (!pass.equals(usermap.getpass(id))) {
                pass = takeinp.strinp("Wrong password, enter again: ");
            }
            return usermap.getprof(id);
        }

        String password = takeinp.strinp("Create a password: ");
        professor prof = new professor(id, password);
        usermap.addprof(id, prof);
        usermap.addpass(id, password);
        userlist.addproflist(prof);
        System.out.println("Professor account created!");
        return prof;
    }

    public static admin mkadmin() {
        String pass = takeinp.strinp("Enter admin password: ");
        while (!pass.equals("admin@IIITD")) {
            pass = takeinp.strinp("Wrong password, enter again: ");
        }
        admin adm = new admin();
        return adm;
    }
}
