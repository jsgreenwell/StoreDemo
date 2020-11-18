package loggers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes log files
 * Basic because this will likely become a parent for other types of logs
 */
public class BasicLogWriter {

  /* File type for our logfile (reset in constructor if diffent file passed)
     default writer object to share among class methods
   */
  private File logFile = new File("./src/inventory.log");
  private BufferedWriter writer;

  public BasicLogWriter() throws IOException {
    loadFile();
  }

  public BasicLogWriter(String filename) throws IOException {
    logFile = new File("./src/" + filename.toLowerCase());
    loadFile();
  }

  protected void loadFile() throws IOException {
    if (!logFile.exists()) {
      logFile.createNewFile();
    }

    try {
      writer = new BufferedWriter(new FileWriter(logFile, true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Prints information on non-critical event to logfile
   * @param information to print to file
   */
  public void INFO(String information) {
    String toLog = String.format("INFORMATION: %s%n", information);
    try {
      writer.write(toLog);
      writer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

    /**
     * Prints information on critical event with crash to logfile
     * @param crashInfo to print to file
     */
    public void FAILURE (String crashInfo) {
      String toLog = String.format("FAILURE - CRITICAL: %s%n", crashInfo);
      try {
        writer.write(toLog);
        writer.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
}
