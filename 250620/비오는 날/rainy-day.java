import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PredictWeatherData[] weatherDataSet = new PredictWeatherData[n];
        for (int i = 0; i < n; i++) {
            String date = sc.next();
            String day = sc.next();
            String weather = sc.next();
            // Please write your code here.

            weatherDataSet[i] = new PredictWeatherData(date, day, weather);
        }

        Arrays.sort(weatherDataSet, (a,b) -> {
            return a.date.compareTo(b.date);
        });

        for (int i = 0; i < n; i++) {
            if (weatherDataSet[i].weather.equals("Rain")) {
                System.out.println(weatherDataSet[i].date + " " + weatherDataSet[i].day + " " + weatherDataSet[i].weather);
                break;
            }
        }
    }

    

    
}

class PredictWeatherData {
    String date;
    String day;
    String weather;

    PredictWeatherData(String date, String day, String weather) {
        this.date = date;
        this.day = day;
        this.weather = weather;
    }
}

// 날짜 순으로 정렬 -> 
// 순차로 돌다가 Rain 찾으면 해당 인덱스의 날짜요일날씨 출력