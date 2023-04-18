import java.util.Date;
import java.util.List;

public record LendRecord(User user, List<Book> books, Date lendDate, Date returnDate) {

}
