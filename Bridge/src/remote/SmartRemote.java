package remote;

import devices.Device;
import devices.SmartTv;

import java.util.Scanner;

public class SmartRemote extends AdvancedRemote  {
  public SmartRemote(Device device) {
    super(device);
  }

  public void voiceControl() {
    Scanner sc = new Scanner(System.in);
    System.out.println("SmartRemote: Enter voice command");
    String command = sc.nextLine();

    if (command.startsWith("launch")) {
      launchApp(command.substring(7).trim());
      return;
    }

    switch (command.toLowerCase().trim()) {
      case "volume up" -> volumeUp();
      case "volume down" -> volumeDown();
      case "mute" -> mute();
      case "channel up" -> channelUp();
      case "channel down" -> channelDown();
      case "power" -> power();
      case "browser" -> openBrowser();
      default -> System.out.println("SmartRemote: unrecognised command.");
    }
  }

  public void openBrowser() {
    if (device instanceof SmartTv) {
      Scanner sc = new Scanner(System.in);
      System.out.println("SmartRemote: Enter url");
      String url = sc.nextLine();
      ((SmartTv) device).browseInternet(url.toLowerCase().trim());
    }
    else {
      System.out.println("SmartRemote: device does not support browsing.");
    }
  }

  public void launchApp(String appName) {
    if (device instanceof SmartTv) {
      ((SmartTv) device).launchApp(appName);
    }
    else {
      System.out.println("SmartRemote: device does not support apps.");
    }
  }
}
