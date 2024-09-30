public class feedback<T> { // Making feedback a generic class

    public feedback(String code, T rating) {

        // String profname = takeinp.strinp("Enter professor name: ");
        for (professor proff : userlist.getproflist()) {
            for (prof_course prcr : proff.getcompleted()) {
                if (code.equals(prcr.code)) {
                    if (rating instanceof String) {
                        String feed = (String) rating;
                        prcr.set_feedback_str(feed);
                        return;
                    } else if (rating instanceof Integer) {
                        int feed = (int) rating;
                        prcr.set_feedback_int(feed);
                        return;
                    }

                }
            }
        }
        System.out.println("No professor found to give feedback");
    }
}
