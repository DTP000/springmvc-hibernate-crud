package tk.dtp000.springmvcandhibernate.crudtwotable.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import tk.dtp000.springmvcandhibernate.crudtwotable.entity.Company;
import tk.dtp000.springmvcandhibernate.crudtwotable.service.CompanyService;
 


@RequestMapping("/api/company")
@RestController
public class CompanyController {

	@Autowired CompanyService companyService;
	

//	@GetMapping("/list")
//	public String listCustomers(Model model) {
//		List<Company> companies = companyService.getCompanies();
//		model.addAttribute("companies", companies);
//		return "list-companies";
//	}
//	
//	@GetMapping("/showForm")
//	public String showFormForAdd(Model model) {
//		Company c = new Company();
//		model.addAttribute("company", c);
//		return "company-form";
//	}
//	
//	@PostMapping("/saveCompany")
//	public String saveCustomer(@ModelAttribute("company") Company company) {
//		companyService.save(company);	
//		return "redirect:/company/list";
//	}
//	
//	@GetMapping("/updateForm")
//	public String showFormForUpdate(@RequestParam("companyId") int id,
//									Model model) {
//		Company c = companyService.find(id);	
//		model.addAttribute("company", c);
//		return "company-form";
//	}
//	
//	@GetMapping("/delete")
//	public String deleteCustomer(@RequestParam("companyId") int id) {
//		companyService.destroy(id);
//		return "redirect:/company/list";
//	}
	
	@RequestMapping(value="/companies", method = RequestMethod.GET)
	public ResponseEntity<List<Company>> listAllCompanies() {
        List<Company> companies = companyService.getCompanies();
        if(companies.isEmpty()){
            return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Company>>(companies, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/company", method = RequestMethod.POST)
    public ResponseEntity<Void> createCompanies(@RequestBody Company company,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + company.getName());
 
        if (companyService.find(company.getId()) != null) {
            System.out.println("A User with name " + company.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        companyService.save(company);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/company/{id}").buildAndExpand(company.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> getCompany(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        Company company = companyService.find(id);
        if (company == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/company/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
        System.out.println("Updating User " + id);
         
        Company currentCompany = companyService.find(id);
         
        if (currentCompany==null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
 
//        currentCompany.setName(company.getName());
//        currentCompany.

        companyService.save(company);
        return new ResponseEntity<Company>(currentCompany, HttpStatus.OK);
    }
 
    //------------------- Delete a User --------------------------------------------------------
     
    @RequestMapping(value = "/company/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Company> deleteCompany(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting User with id " + id);
 
        Company user = companyService.find(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
 
        companyService.destroy(id);
        return new ResponseEntity<Company>(HttpStatus.NO_CONTENT);
    }
}
