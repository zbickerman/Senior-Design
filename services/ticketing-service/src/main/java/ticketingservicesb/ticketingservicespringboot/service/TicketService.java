package ticketingservicesb.ticketingservicespringboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ticketingservicesb.ticketingservicespringboot.model.Contractor;
import ticketingservicesb.ticketingservicespringboot.model.Student;
import ticketingservicesb.ticketingservicespringboot.model.Ticket;
import ticketingservicesb.ticketingservicespringboot.repository.ContractorRepository;
import ticketingservicesb.ticketingservicespringboot.repository.StudentRepository;
import ticketingservicesb.ticketingservicespringboot.repository.TicketRepository;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final StudentRepository studentRepository;
    private final ContractorRepository contractorRepository;

    public TicketService(TicketRepository ticketRepository,
                         StudentRepository studentRepository,
                         ContractorRepository contractorRepository) {
        this.ticketRepository = ticketRepository;
        this.studentRepository = studentRepository;
        this.contractorRepository = contractorRepository;
    }

    public Ticket createTicket(Ticket ticket, Long studentId, Long contractorId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        ticket.setStudent(student);

        if (contractorId != null) {
            Contractor contractor = contractorRepository.findById(contractorId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contractor not found"));
            ticket.setContractor(contractor);
        }

        return ticketRepository.save(ticket);
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found"));
    }

    public List<Ticket> getTicketsByStudent(Long studentId) {
        return ticketRepository.findByStudentStudentId(studentId);
    }

    public List<Ticket> getTicketsByContractor(Long contractorId) {
        return ticketRepository.findByContractorId(contractorId);
    }

    public List<Ticket> getTicketsByStatus(String status) {
        return ticketRepository.findByStatus(status);
    }

    public Ticket updateTicket(Long id, Ticket updated, Long contractorId) {
        Ticket existing = getTicketById(id);
        existing.setTitle(updated.getTitle());
        existing.setDescription(updated.getDescription());
        existing.setStatus(updated.getStatus());
        existing.setPhotoUrls(updated.getPhotoUrls());

        if (contractorId != null) {
            Contractor contractor = contractorRepository.findById(contractorId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contractor not found"));
            existing.setContractor(contractor);
        }

        return ticketRepository.save(existing);
    }

    public void deleteTicket(Long id) {
        if (!ticketRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Ticket not found");
        }
        ticketRepository.deleteById(id);
    }
}
