package bai1;

public class StringVsStringBuffer {
    private static final int loop = 100000;
    // ham 1 : noi chuoi bang string +=
    public static long useString(){
        long start = System.currentTimeMillis();
        String s = "";
        for(int i=0; i<loop; i++){
            s += "Hello";
        }
        long end = System.currentTimeMillis();
        System.out.println("Do dai chuoi String : " + s.length());
        return end - start;
    }

    //ham 2 : noi chuoi bang String buffer (append)
    public static long useStringBuffer(){
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<loop; i++){
            sb.append("Hello");
        }
        long end = System.currentTimeMillis();
        System.out.println("Do dai chuoi StringBuffer : " + sb.length());
        return end - start;
    }
    // ham 3 : phan tich noi dung.
    public static void contentAnalysis(String text){
        int sentenceCnt = 0;
        for(int i=0; i < text.length(); i++){
            char c = text.charAt(i);
            if(c == '.' || c == '?' || c == '!'){
                sentenceCnt++;
                while(i+1 < text.length() && isEndMark(text.charAt(i + 1))){
                    i++;
                }
            }
        }
        System.out.println("So cau : " + sentenceCnt);

        StringBuffer sb = new StringBuffer(text);
        String target = "Java";
        String replacement = "Python";
        int replaced = 0;

        int index = sb.indexOf(target);
        while(index != -1){
            sb.replace(index, index + target.length(), replacement);
            replaced++;
            index = sb.indexOf(target, index + replacement.length());
        }
        System.out.println("So lan thay the: " + replaced);
        System.out.println("Van ban sau khi thay the : \n" + sb);
    }

    private static boolean isEndMark(char c){
        return c == '.' || c == '?' || c == '!';
    }

    public static void main(String[] args) {
        long t1 = useString();
        long t2 = useStringBuffer();
        System.out.println("useString:       " + t1 + " ms");
        System.out.println("useStringBuffer: " + t2 + " ms");

        // Phần 3: phân tích văn bản
        String text = "Java là ngôn ngữ lập trình hướng đối tượng. "
                + "Bạn đã học Java chưa? Rồi à... Tuyệt vời! "
                + "Nhiều trường dạy Java trong môn OOP, "
                + "nhưng Java không phải là lựa chọn duy nhất (C++, Python, C#...). "
                + "Hãy thử viết code Java ngay hôm nay!!! "
                + "Email: abc@uet.vnu.edu.vn";

        System.out.println("\n--- contentAnalysis ---");
        contentAnalysis(text);
    }
}
