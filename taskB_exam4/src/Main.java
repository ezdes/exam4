public class Main {

    public static void main(String[] args) {
        System.out.println(NewsDb.insert("AAAAAAAAAAAAAAAA", "BBBBBBBBBBBBBBBBB") ? "Successfully inserted!" : "Insertion failed!");
        System.out.println(NewsDb.insert("CCCCCCCCCCCCCCCC", "DDDDDDDDDDDDDDDDD") ? "Successfully inserted!" : "Insertion failed!");

        NewsDb.show(1);
        NewsDb.show(2);

        System.out.println(NewsDb.update(1) ? "Successfully updated!" : "Updation failed!");
        System.out.println(NewsDb.update(2) ? "Successfully updated!" : "Updation failed!");

        NewsDb.show(1);
        NewsDb.show(2);

        System.out.println(NewsDb.delete(1) ? "Successfully deleted" : "Deletion failed!");

    }

    public static String generate() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder(10);

        for (int i = 0; i < 10; i++) {
            int index = (int)(letters.length() * Math.random());
            sb.append(letters.charAt(index));
        }

        return sb.toString();
    }
}
