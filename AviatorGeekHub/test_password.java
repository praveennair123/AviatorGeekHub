import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test_password {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String password = "password";
        String encoded = encoder.encode(password);
        System.out.println("Encoded password: " + encoded);
        
        // Test if it matches
        boolean matches = encoder.matches(password, encoded);
        System.out.println("Password matches: " + matches);
        
        // Test with the hash we're using
        String ourHash = "$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iKTVEFDa";
        boolean ourMatches = encoder.matches(password, ourHash);
        System.out.println("Our hash matches: " + ourMatches);
    }
}
