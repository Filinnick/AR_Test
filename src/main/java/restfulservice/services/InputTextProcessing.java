package restfulservice.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InputTextProcessing {

    private String inputString;

    public String getOutputString() {
        return stringProcessing(inputString);
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    //метод для обработки текста, полученного в запросе
    private String stringProcessing(String string) {

        //разбиваем текст на строки, избавляясь от пробелов
        List<String> letterLines = new ArrayList<String>();
        for(int i = 0, n = string.length() ; i < n ; i++) {
            if (i == n-1) {
                letterLines.add(string.replace(" ",""));
                //string = "";
                break;
            }
            if (string.charAt(i) == '\n') {
                letterLines.add(string.substring(0,i+1).replace(" ",""));
                string = string.replace(string.substring(0,i+1),"");
                i=0;
                n = string.length();
            }
        }

        //получаем строки порядковых номеров букв
        List<String> numLines = new ArrayList<String>();
        for (String letterLine : letterLines) {
            numLines.add(letterToNums(letterLine));
        }

        //формируем выходной текст
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numLines.size(); i++) {
            String currentLetterLine = letterLines.get(i);
            String currentNumLine = numLines.get(i);
            for(int j =0; j < currentLetterLine.length(); j++){
                sb.append(currentLetterLine.charAt(j));

                //обработка знаков препинания и строковых символов
                int c = currentLetterLine.charAt(j);
                if((c >= 1040 && c <= 1103) || (c == 1105 || c == 1025) ) sb.append("  ");
            }
            if(i == numLines.size() - 1) sb.append("\r\n");
            sb.append(numLines.get(i));

        }
        return sb.toString();
    }

    //метод преобразования букву в цифру
    private String letterToNums(String line) {
        StringBuilder sb = new StringBuilder();
        for(char c : line.toCharArray()){
            int resultCharCode = c;

            //Буквы ё и Ё
            if (c == 1105 || c == 1025)
            {
                sb.append(7);
                sb.append("  ");
            }

            //буквы перед ё и Ё верхний регистр
            else if (c >= 1040 && c <= 1045)
            {
                resultCharCode = c - 1039;
                sb.append(resultCharCode);
                if(resultCharCode > 9) sb.append(" ");
                if(resultCharCode <= 9) sb.append("  ");
            }

            //буквы после ё и Ё верхний регистр
            else if (c >= 1046 && c <= 1071)
            {
                resultCharCode = c - 1038;
                sb.append(resultCharCode);
                if(resultCharCode > 9) sb.append(" ");
                if(resultCharCode <= 9) sb.append("  ");
            }

            //буквы до ё и Ё нижний регистр
            else if (c >= 1072 && c <= 1077)
            {
                resultCharCode = c - 1071;
                sb.append(resultCharCode);
                if(resultCharCode > 9) sb.append(" ");
                if(resultCharCode <= 9) sb.append("  ");
            }

            //буквы после ё и Ё нижний регистр
            else if (c >= 1078 && c <= 1103)
            {
                resultCharCode = c - 1070;
                sb.append(resultCharCode);
                if(resultCharCode > 9) sb.append(" ");
                if(resultCharCode <= 9) sb.append("  ");
            }
            else sb.append(c);
        }

        return sb.toString();
    }




}
