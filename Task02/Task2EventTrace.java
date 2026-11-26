import java.util.*;
public class Task2EventTrace {
  public static void main(String[] args) {
    System.out.println("Window opened -> create components -> register listeners -> load departments");
    System.out.println("Department selected -> ActionEvent -> JComboBox listener -> refresh doctor list");
    System.out.println("Book clicked -> ActionEvent -> validate fields -> book appointment -> show confirmation");
    System.out.println("Close clicked -> WindowEvent -> WindowListener -> dispose window");
    System.out.println("Doctor refresh: query selected department, update model, clear stale selection.");
    System.out.println("Booking pseudocode: if valid, call AppointmentService.book(); show success; else show error.");
    System.out.println("Applet init/start/paint/stop/destroy are lifecycle callbacks; JFrame uses window events.");
    System.out.println("DB each time: fresh data but slower. Map cache: faster lookups but can become stale.");
  }
}
