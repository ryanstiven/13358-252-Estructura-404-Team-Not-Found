public class Team {

    private String name;
    private int stars;
    private int intlParticipations;
    private int intlFinals;
    private int localFinals;
    private long fans;
    private double marketValue;
    private double payroll;

    public Team() {}

    public Team(String name, int stars, int intlParticipations,
                int intlFinals, int localFinals, long fans,
                double marketValue, double payroll) {

        this.name = name;
        this.stars = stars;
        this.intlParticipations = intlParticipations;
        this.intlFinals = intlFinals;
        this.localFinals = localFinals;
        this.fans = fans;
        this.marketValue = marketValue;
        this.payroll = payroll;
    }

    public final static void sortByStars(Team[] teams) {
        int N = teams.length;
        for (int i = 1; i < N; i++) {
            Team current = teams[i];
            int key = current.stars;
            int j = i - 1;
            while (j >= 0 && teams[j].stars > key) {
                teams[j + 1] = teams[j];
                j--;
            }
            teams[j + 1] = current;
        }
    }

    public final static void sortByintlParticipations(Team[] teams) {
        int N = teams.length;
        for (int i = 1; i < N; i++) {
            Team current = teams[i];
            int key = current.intlParticipations;
            int j = i - 1;
            while (j >= 0 && teams[j].intlParticipations > key) {
                teams[j + 1] = teams[j];
                j--;
            }
            teams[j + 1] = current;
        }
    }

    public final static void sortBylocalFinals(Team[] teams) {
        int N = teams.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (teams[j].localFinals > teams[j + 1].localFinals) {
                    Team temp = teams[j];
                    teams[j] = teams[j + 1];
                    teams[j + 1] = temp;
                }
            }
        }
    }

    public final static void sortByMarketValue(Team[] teams) {
        int N = teams.length;
        for (int i = 0; i < N - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (teams[j].marketValue < teams[minIdx].marketValue) {
                    minIdx = j;
                }
            }
            Team temp = teams[i];
            teams[i] = teams[minIdx];
            teams[minIdx] = temp;
        }
    }

    public final static void sortByintlFinals(Team[] teams) {
        int N = teams.length;
        for (int i = 1; i < N; i++) {
            Team current = teams[i];
            int key = current.intlFinals;
            int j = i - 1;
            while (j >= 0 && teams[j].intlFinals > key) {
                teams[j + 1] = teams[j];
                j--;
            }
            teams[j + 1] = current;
        }
    }

    public final static void sortByFans(Team[] teams) {
        int N = teams.length;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (teams[j].fans > teams[j + 1].fans) {
                    Team temp = teams[j];
                    teams[j] = teams[j + 1];
                    teams[j + 1] = temp;
                }
            }
        }
    }

    public final static void sortByPayroll(Team[] teams) {
        int N = teams.length;
        for (int i = 0; i < N - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < N; j++) {
                if (teams[j].payroll < teams[minIdx].payroll) {
                    minIdx = j;
                }
            }
            Team temp = teams[i];
            teams[i] = teams[minIdx];
            teams[minIdx] = temp;
        }
    }

    public static final void printer(Team[] teams) {
        String header = String.format(
                "%-22s %6s %6s %8s %9s %12s %14s %12s",
                "Team","Stars","Intl","IntlFin","LocalFin","Fans","MarketValue","Payroll"
        );
        String sep = "-".repeat(header.length());
        System.out.println(header);
        System.out.println(sep);

        for (Team t : teams) {
            String fansStr = java.text.NumberFormat
                    .getInstance(java.util.Locale.US)
                    .format(t.fans);
            System.out.printf("%-22s %6d %6d %8d %9d %12s %14s %12s%n",
                    t.name,
                    t.stars,
                    t.intlParticipations,
                    t.intlFinals,
                    t.localFinals,
                    fansStr,
                    String.format("%.2fM", t.marketValue),
                    String.format("%.2fM", t.payroll)
            );
        }
        System.out.println(sep);
    }

    public final static void main(String[] args) {

        Team t1 = new Team("Once Caldas",         4, 3, 3,  6, 1_800_000L, 11.5,  4.5);
        Team t2 = new Team("Atlético Nacional",  18, 7,13, 30,11_591_000L, 25.3, 12.0);
        Team t3 = new Team("Millonarios",        16, 4, 2, 26, 8_996_000L, 15.8, 10.0);

        Team[] teams = {t1, t2, t3};

        System.out.println("Ordenado por Stars:");
        sortByStars(teams);
        printer(teams);

        System.out.println("Ordenado por Intl Participations:");
        sortByintlParticipations(teams);
        printer(teams);

        System.out.println("Ordenado por Intl Finals:");
        sortByintlFinals(teams);
        printer(teams);

        System.out.println("Ordenado por Local Finals:");
        sortBylocalFinals(teams);
        printer(teams);

        System.out.println("Ordenado por Fans:");
        sortByFans(teams);
        printer(teams);

        System.out.println("Ordenado por Market Value:");
        sortByMarketValue(teams);
        printer(teams);

        System.out.println("Ordenado por Payroll:");
        sortByPayroll(teams);
        printer(teams);
    }
}
