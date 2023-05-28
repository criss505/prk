import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Audit {
    FileWriter writer;
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void logAction(String action) throws IOException {
        this.writer.append(action);
        this.writer.append(" - ");
        this.writer.append(this.formatter.format(LocalDateTime.now()));
        this.writer.append("\n");
        this.writer.flush();
    }

    public Audit() {
        try {
            this.writer = new FileWriter("audit.csv");
        } catch (IOException var2) {
            System.out.println(var2.toString());
        }

    }
}
