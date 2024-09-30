public class mkuser {

    public static student mkstud() {
        String id = takeinp.strinp("Enter student ID: ");
        if (usermap.stud_exist(id)) {
            System.out.println("User already exists!");
            boolean valid = false;
            while (!valid) {
                try {
                    takepass(id);
                    valid = true;
                } catch (InvalidLoginException e) {
                    System.out.println(e);
                }
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
            boolean valid = false;
            while (!valid) {
                try {
                    takepass(id);
                    valid = true;
                } catch (InvalidLoginException e) {
                    System.out.println(e);
                }
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
        boolean valid = false;
        while (!valid) {
            try {
                takeadminpass();
                valid = true;
            } catch (InvalidLoginException e) {
                System.out.println(e);
            }
        }
        admin adm = new admin();
        return adm;
    }

    private static void takepass(String id) throws InvalidLoginException {
        String pass = takeinp.strinp("Enter password: ");
        if (!pass.equals(usermap.getpass(id))) {
            throw new InvalidLoginException("Wrong password!!\n");
        }

        // return pass;
    }

    private static void takeadminpass() throws InvalidLoginException {
        String pass = takeinp.strinp("Enter admin password: ");
        if (!pass.equals("admin@IIITD")) {
            throw new InvalidLoginException("Wrong password!!\n");
        }
    }
}
