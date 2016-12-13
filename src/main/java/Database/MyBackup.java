package Database;


import java.io.IOException;

public class MyBackup implements Backup {

    public void makeBackup() throws IOException {
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("C:\\Program Files\\MySQL\\MySQL Server 5.7\\bin\\mysqldump -u sql7146768 -pw2gAY97YQQ  sql7146768 -r  D:\\BackupTest.sql");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getBackup() {

    }

}
