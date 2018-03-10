package com.mycompany;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainTvpHistoria {

    public static void main(String[] args) throws IOException {

        String path = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\input\\TVP Historia.txt";
        String pathOut = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\output\\outputTVP Historia1.txt";
        String pathOut2 = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\output\\outputTVP Historia2.txt";
        String pathOut3 = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\output\\outputTVP Historia3.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(path));
            writer = new BufferedWriter(new FileWriter(pathOut));

            String line1;

            while ((line1 = reader.readLine()) != null) {
                writer.write(line1
                        .replace("; Bez ograniczeń wiekowych", "")
                        .replace("; Dla małoletnich od lat 12", "")
                        .replace("; Dla małoletnich od lat 16", "")
                        .replace("; Dla małoletnich od lat 7", "")
                        .replace("; ", " - ")
                        .replace(" kraj prod.", ", prod. ")
                        .replace(" - reż.:", ", reż. ")
                        .replace(" - wyk.:", ", wyk. ")
                        .replace(" AD", "")
                        .replace("-  txt. str. 777 ", "")
                        .replace("  ", " ")
                );

                writer.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(pathOut));
            writer = new BufferedWriter(new FileWriter(pathOut2));

            String line2;

            while ((line2 = reader.readLine()) != null) {

                Pattern pattern = Pattern.compile("odc. ([0-9]{1,3})/([0-9]{1,3}) ");
                Pattern pattern2 = Pattern.compile("odc. ([0-9]{1,3}) ");

                Matcher matcher = pattern.matcher(line2);
                Matcher matcher2 = pattern2.matcher(line2);

                if (matcher.find()) {
                    writer.write(line2
                            .replace(matcher.group(), "")
                    );
                } else if (matcher2.find()) {
                    writer.write(line2
                            .replace(matcher2.group(), "")
                    );
                } else {
                    writer.write(line2
                            .replace("", ""));
                }
                writer.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }

        try {
            reader = new BufferedReader(new FileReader(pathOut2));
            writer = new BufferedWriter(new FileWriter(pathOut3));

            String line3;

            while ((line3 = reader.readLine()) != null) {
                    // szuka stringow (1), (12), (123) lub (1234)
                Pattern pattern = Pattern.compile("\\(([0-9]{1,4})\\)");
                Matcher matcher = pattern.matcher(line3);

                if (matcher.find()) {
                    String foundMatcher = matcher.group();
                    //  zamienia znalezione stringi np. (2012) na 2012
                    writer.write(line3
                            .replace(foundMatcher, foundMatcher.substring(1, matcher.group().length() - 1))
                    );
                }
                 else {
                    writer.write(line3
                            .replace("", ""));
                }
                writer.append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
}
