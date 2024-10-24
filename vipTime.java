import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

public class vipTime
{
  protected static Long updatedAt;
  public static final long DAY28 = TimeUnit.DAYS.toMillis(28);
  // 保級期限
  private static long regularDeadlineAt;

  // 晉級期限
  private static long upgradeDeadlineAt;

  // 晉級起始時間
  private static long upgradeDeadlineStartAt;

  public static void generateDeadlineAt(int resetDay) {
    var resetDayTime = TimeUnit.DAYS.toMillis(resetDay);
    regularDeadlineAt =updatedAt + DAY28;
    long nowTime = System.currentTimeMillis();
    long upgradeDeadlineAtTemp = updatedAt + resetDayTime;
    long upgradeDeadlineStartAtTemp = updatedAt;
    while (nowTime > upgradeDeadlineAtTemp) {
      upgradeDeadlineAtTemp += resetDayTime;
      upgradeDeadlineStartAtTemp += resetDayTime;
    }
    //改12  +  12
    upgradeDeadlineAt = upgradeDeadlineAtTemp;
    upgradeDeadlineStartAt = upgradeDeadlineStartAtTemp;
  }
  public static void main(String[] args) {
    updatedAt=1620305600000L;
    generateDeadlineAt(26);
    System.out.println("保級期限regularDeadlineAt:"+regularDeadlineAt);
    System.out.println("晉級期限upgradeDeadlineAt:"+upgradeDeadlineAt);
    System.out.println("晉級起始時間upgradeDeadlineStartAt:"+upgradeDeadlineStartAt);
  }

}
