package com.mycompany;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainTvpHistoria {

    public static void main(String[] args) throws IOException {

        String path = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\input\\TVP Historia.txt";
        String pathOut = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\output\\outputTVP Historia1.txt";
        String pathOut2 = "E:\\IdeaProjects\\ProgramObrobkaPlikowTV\\documents\\output\\outputTVP Historia2.txt";
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

                Pattern pattern = Pattern.compile("odc. ([0-9]{1,3})/([0-9]{1,3})");
                Matcher matcher = pattern.matcher(line2);

                if (matcher.find()) {
                    System.out.println(matcher.group());
                    writer.write(line2
                            .replace(matcher.group(), "")
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
    }
}
