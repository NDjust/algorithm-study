package kakao.prac;

import java.sql.SQLOutput;
import java.util.*;

public class FileSorting {

    public String[] solution(String[] files) {
        String[] ans = new String[files.length];

        List<File> fileList = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            File file1 = convertFileObject(i, files[i]);
            fileList.add(file1);
        }

        fileList.sort(new Comparator<File>() {
            @Override
            public int compare(final File f1, final File f2) {

                if (!f1.head.equals(f2.head)) {
                    return f1.head.compareTo(f2.head);
                }

                int f1Num = Integer.parseInt(f1.num);
                int f2Num = Integer.parseInt(f2.num);

                if (f1Num != f2Num) {
                    return f1Num - f2Num;
                }

                return f1.originIdx - f2.originIdx;
            }
        });

        for (int i = 0; i < fileList.size(); i++) {
            ans[i] = fileList.get(i).getOriginString();
        }

        return ans;
    }

    private File convertFileObject(final int originIdx, final String file) {
        StringBuilder Head = new StringBuilder();
        StringBuilder Number = new StringBuilder();
        String Tail = "";

        StringBuilder sb = new StringBuilder();
        String name = file.toLowerCase();
        for(int i=0; i<name.length(); ++i) {
            char word = name.charAt(i);

            // 현재 문자가 알파벳 또는 - 인 경우 or Number를 담다가 다시 문자를 만나는 경우
            if ((word-'a' >= 0 && word-'a' <= 26) || (word == '-' || word == '.' || word == ' ' )) {

                // Head와 Number가 모두 갱신되었다면 -> 나머지는 Tail
                if(!Number.toString().equals("")) {
                    Tail += file.substring(i);
                    break;
                }

                else {
                    Head.append(file.charAt(i));
                }
            }

            // 현재 문자가 숫자인 경우 -> 이Number를 담기
            else if(word-'0'>=0 && word-'0'<=57) {
                Number.append(file.charAt(i));
            }
        }

        return new File(originIdx, file, Head.toString(), Number.toString(), Tail);
    }

    private static class File {
        Integer originIdx;
        String originString;
        String head;
        String num;
        String tail;


        public File(final Integer originIdx, final String originString, final String head, final String num, final String tail) {
            this.originIdx = originIdx;
            this.originString = originString;
            this.head = head.toLowerCase();
            this.num = num;
            this.tail = tail.toLowerCase();
        }

        @Override
        public String toString() {
            return "File{" +
                    "head='" + head + '\'' +
                    ", num='" + num + '\'' +
                    ", tail='" + tail + '\'' +
                    '}';
        }



        public String getOriginString() {
            return originString;
        }
    }

    public static void main(String[] args) {
        FileSorting sorting = new FileSorting();
        String[] text = new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] solution = sorting.solution(text);
    }
}
