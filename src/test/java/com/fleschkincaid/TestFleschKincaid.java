package com.fleschkincaid;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kenny on 3/11/14.
 */
public class TestFleschKincaid {

    private FleschKincaid fleshKincaid = new FleschKincaid();

    @Test
    public void control() {
        //                                            Expected / Actual
        test(read("control/cat_in_the_hat.txt"));       // 111 / 108
        test(read("control/cnn_article.txt"));          // 52  / 44.9
        test(read("control/gettysburg_address.txt"));   // 66  / 63
        test(read("control/harry_potter.txt"));         // 64  / 59.3
        test(read("control/state_of_the_union.txt"));   // 70  / 57.2
        test(read("control/voter_preference.txt"));     // 28.7/ 26.9
    }

    @Test
    public void misc() {
        test(read("childrens_story1.txt"));
        test(read("childrens_story2.txt"));
        test(read("childrens_story3.txt"));
        test(read("lawyer1.txt"));
        test(read("lawyer2.txt"));
        test(read("lawyer3.txt"));

        test(read("sample_textbook.txt"));
        test(read("sample_essay1.txt"));
        test(read("sample_essay2.txt"));
        test(read("sample_essay3.txt"));
        test(read("sample_essay4.txt"));

        test(read("4th_grade_essay1.txt"));

        test(read("kindergarten_essay1.txt"));
        test(read("kindergarten_essay2.txt"));
        test(read("kindergarten_essay3.txt"));
    }

    private void test(String text) {
        System.out.println(fleshKincaid.calculate(text));
    }

    private String read(String filename) {
        try {
            System.out.println("Reading file: " + filename);
            Scanner s;
            if(filename.startsWith("/")) {
                s = new Scanner(new File(filename));
            } else {
                s = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream(filename));
            }
            StringBuilder builder = new StringBuilder();

            String text = "";
            while(s.hasNextLine()) builder.append(s.nextLine() + "\n");
            s.close();
            text = builder.toString();
            return text;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

}

