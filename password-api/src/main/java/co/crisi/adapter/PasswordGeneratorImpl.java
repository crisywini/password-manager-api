package co.crisi.adapter;

import co.crisi.port.PasswordGenerator;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Component
public class PasswordGeneratorImpl implements PasswordGenerator {

    private final RestTemplate restTemplate;
    private final char[] alphabetLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private final char[] alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private final char[] numbers = "0123456789".toCharArray();
    private final char[] especialCharacters = "~',.;<>#$%&/()=?¿*+-!".toCharArray();


    public PasswordGeneratorImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public String generatePassword() {
        return encryptGivingPassword();
    }

    private String encryptGivingPassword(){
        //This is a test and could change the password generator source
        String url = "https://www.passwordrandom.com/query?command=password";

        String password = restTemplate.getForObject(url, String.class);
        StringBuilder encrypted = new StringBuilder();
        int alphabetLowerSize = alphabetLower.length;
        int alphabetUpperSize = alphabetUpper.length;
        int numbersSize = numbers.length;
        int charactersSize = especialCharacters.length;
        Random random = new Random();
        int sizeArrays = 4;
        for(int i=0; i<password.length(); i++){
            int arrIndexToChoose = random.nextInt(sizeArrays);
            if(arrIndexToChoose == 0){
                encrypted.append(alphabetLower[random.nextInt(alphabetLowerSize)]);

            }else if(arrIndexToChoose==1){
                encrypted.append(alphabetUpper[random.nextInt(alphabetUpperSize)]);

            }else if(arrIndexToChoose==2){
                encrypted.append(numbers[random.nextInt(numbersSize)]);

            }else {
                encrypted.append(especialCharacters[random.nextInt(charactersSize)]);
            }
            encrypted.append(password.charAt(i));
        }

        return encrypted.toString();
    }

}
