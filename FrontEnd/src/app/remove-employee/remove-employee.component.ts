import { identifierModuleUrl } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employeemain';




@Component({
  selector: 'app-remove-employee',
  templateUrl: './remove-employee.component.html',
  styleUrls: ['./remove-employee.component.css']
})
export class RemoveEmployeeComponent  {
  id : number;
  employee: Employee;
  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: EmployeeService) { }
    ngOnInit() {
      this.employee = new Employee();

    }
    

   deleteEmployee()
   {
    this.employeeService.deleteEmployee(this.id)
    .subscribe(data => {
      console.log(data);
      this.employee = new Employee();
    }, error => console.log(error));
   }
   onSubmit() {
    this.deleteEmployee();    
  }

 

  showModal : boolean;
  showModal1 : boolean;
  onClick(event)
  {
    this.showModal = true; // Show-Hide Modal Check
   
  }
  //Bootstrap Modal Close event
  hide()
  {
    this.showModal = false;
  }
  onClick1(event)
  {
    this.showModal1 = true; // Show-Hide Modal Check
   
  }
  //Bootstrap Modal Close event
  hide1()
  {
    this.showModal1 = false;
  }

 

}

