package devices;

public class SmartTv extends Tv {
  private String currentApp = "Home Screen";   // extra state
  private boolean internetConnected = false;

  public void browseInternet(String url) {
    if (!isEnabled()) enable();
    if (internetConnected) {
      currentApp = "Browser: " + url;
      return;
    }
    System.out.println("SmartTV: no internet.");
  }

  public void launchApp(String appName) {
    if (!isEnabled()) enable();
    currentApp = appName;
  }

  public void connectInternet() {
    this.internetConnected = true;
  }

  public void disconnectInternet() {
    this.internetConnected = false;
  }

  @Override
  public void printStatus() {
    System.out.println("------------------------------------");
    System.out.println("| I'm SmartTV.");
    System.out.println("| I'm " + (isEnabled() ? "enabled" : "disabled"));
    System.out.println("| Current volume is " + getVolume() + "%");
    System.out.println("| Current channel is " + getChannel());
    System.out.println("| Current app is " + currentApp);
    System.out.println("------------------------------------\n");
  }
}
