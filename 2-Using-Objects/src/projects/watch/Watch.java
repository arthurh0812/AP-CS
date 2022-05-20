package projects.watch;

public class Watch {
    private final static int SECS_PER_DAY = 3600 * 24;
    private final static int SECS_PER_HOUR = 3600;
    private final static int SECS_PER_MINUTE = 60;
    private final static int MINUTES_PER_HOUR = 60;
    private final static int HOURS_PER_DAY = 24;

    private int hours;
    private int minutes;
    private int seconds;
    public void setHours(int h) {
        if (0 <= h && h < HOURS_PER_DAY) {
            hours = h;
        }
    }
    public int getHours() {
        return hours;
    }
    public void setMinutes(int m) {
        if (0 <= m && m < MINUTES_PER_HOUR) {
            minutes = m;
        }
    }
    public int getMinutes() {
        return minutes;
    }
    public void setSeconds(int s) {
        if (0 <= s && s < SECS_PER_MINUTE) {
            seconds = s;
        }
    }
    public int getSeconds() {
        return seconds;
    }

    private int rest;
    private void setRest(int r) {
        rest = r;
    }
    private int getRest() {
        return rest;
    }
    private int getRestSeconds() {
        int restSecs = rest % SECS_PER_MINUTE;
        rest -= restSecs;
        return restSecs;
    }

    private int getRestMinutes() {
        int restMins = rest % SECS_PER_HOUR;
        rest -= restMins * SECS_PER_MINUTE;
        return restMins;
    }

    private int getRestHours() {
        int restHours = rest % SECS_PER_DAY;
        rest -= restHours * SECS_PER_HOUR;
        return restHours;
    }

    public Watch(int hrs, int mins, int secs) {
        setRest(getSeconds(hrs, mins, secs));
        calculate();
        useSeparator(":");
        useFormat("standard");
    }

    public void calculate() {
        hours = calcHours();
        minutes = calcMinutes();
        seconds = getRest();
    }

    public int calcHours() {
        int rest = getRest();
        int hours = rest / SECS_PER_HOUR;
        setRest(rest % SECS_PER_HOUR);
        return hours;
    }

    public int calcMinutes() {
        int rest = getRest();
        int minutes = rest / SECS_PER_MINUTE;
        setRest(rest % SECS_PER_MINUTE);
        return minutes;
    }

    public void changeTime(int secs) {
        setRest(secs);
        modify();
    }

    public void changeTime(int mins, int secs) {
        setRest(getSeconds(0, mins, secs));
        modify();
    }

    public void changeTime(int hrs, int mins, int secs) {
        setRest(getSeconds(hrs, mins, secs));
        modify();
    }

    public void modify() {
        if (getRest() == 0) {
            return;
        }
        seconds = modifySecs();
        if (getRest() == 0) {
            return;
        }
        minutes = modifyMinutes();
        if (getRest() == 0) {
            return;
        }
        hours = modifyHours();
    }

    public int modifySecs() {
        int restSecs = getRestSeconds();
        int secs = restSecs + seconds;
        if (secs < 0) {
            secs = SECS_PER_MINUTE + secs;
            minutes -= 1;
        } else if (SECS_PER_MINUTE <= secs) {
            secs = secs - SECS_PER_MINUTE;
            minutes += 1;
        }
        return secs;
    }

    public int modifyMinutes() {
        int restMins = getRestMinutes();
        int mins = restMins + minutes;
        if (mins < 0) {
            mins = MINUTES_PER_HOUR + mins;
            hours -= 1;
        } else if (MINUTES_PER_HOUR <= mins) {
            mins = mins - MINUTES_PER_HOUR;
            hours += 1;
        }
        return mins;
    }

    public int modifyHours() {
        int restHours = getRestHours();
        int hrs = restHours + hours;
        if (hrs < 0) {
            hrs = HOURS_PER_DAY - (hrs % HOURS_PER_DAY);
        } else if (HOURS_PER_DAY <= hrs) {
            hrs = hrs % HOURS_PER_DAY;
        }
        return hrs;
    }

    private final static int DAY_START = 6;
    private final static int DAY_END = 20;
    // assuming day is from 6am (incl) to 8pm (excl)
    public boolean isDay() {
        return DAY_START <= hours && hours < DAY_END;
    }

    // returns time difference between the two watches in seconds
    public int timeDiff(Watch w) {
        int other = w.getTotal();
        int curr = getTotal();
        return Math.abs(other - curr);
    }

    private int getSeconds(int hrs, int mins, int secs) {
        return hrs * SECS_PER_HOUR + mins * SECS_PER_MINUTE + secs;
    }

    private int getTotal() {
        return getSeconds(hours, minutes, seconds);
    }

    private TimeFormat format;
    private String separator;

    public void useFormat(String f) {
        format = TimeFormat.valueOf(f.toUpperCase());
    }

    public String getTime() {
        return switch (format) {
            case STANDARD_ENGLISH -> getStandardEnglish();
            case ALARM -> getAlarm();
            case ALARM_ENGLISH -> getAlarmEnglish();
            default -> getStandard();
        };
    }

    private String getStandard() {
        return String.format("%02d%s%02d%s%02d", hours, separator, minutes, separator, seconds);
    }

    private String getStandardEnglish() {
        PeriodData data = getPeriod();
        return String.format("%02d%s%02d%s%02d %s", data.hours, separator, minutes, separator, seconds, data.period);
    }

    private String getAlarm() {
        return String.format("%02d%s%02d", hours, separator, minutes);
    }

    private String getAlarmEnglish() {
        PeriodData data = getPeriod();
        return String.format("%02d%s%02d %s", data.hours, separator, minutes, data.period);
    }

    private PeriodData getPeriod() {
        String period = "am";
        int modHours = hours;
        if (!isAM()) {
            period = "pm";
            modHours = hours - 12;
        }
        return new PeriodData(period, modHours);
    }

    private boolean isAM() {
        return 0 <= hours && hours <= 12;
    }

    public void useSeparator(String sep) {
        separator = sep;
    }
}
