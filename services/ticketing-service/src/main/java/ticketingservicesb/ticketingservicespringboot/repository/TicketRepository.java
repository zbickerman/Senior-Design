package ticketingservicesb.ticketingservicespringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ticketingservicesb.ticketingservicespringboot.model.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByStudentStudentId(Long studentId);

    List<Ticket> findByContractorId(Long contractorId);

    List<Ticket> findByStatus(String status);
}
