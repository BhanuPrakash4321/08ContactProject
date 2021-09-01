package in.bhanuit.serviceimpl;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.bhanuit.entity.Contact;
import in.bhanuit.repository.ContactRepository;
import in.bhanuit.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repository;

	@Override
	public boolean saveContact(Contact contact) {
		Contact save = repository.save(contact);

		if (save != null && save.getContactId() != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
 
		List<Contact> findAll = repository.findAll();
		return findAll;
	}

	@Override

	public Contact getContactById(Integer contactId) {
	
		Optional<Contact> findById = repository.findById(contactId);
		if (findById.isPresent()) {
			Contact contact = findById.get();
			return contact;
		}
		return null;
	}

	@Override

	public boolean deleteContactById(Integer contactId) {

		boolean status = repository.existsById(contactId);

		if (status) {
			repository.deleteById(contactId);
			return true;
		}

		return false;
	}
}
