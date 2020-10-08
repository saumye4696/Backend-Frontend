import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employeemain';


@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent  {
  
  employee: Employee = new Employee();
  submitted = false;
  constructor(private employeeService: EmployeeService, private router : Router) {}
  newEmployee(): void {
    this.submitted = false;
    this.employee = new Employee();
  }
  save() {
    this.employeeService
    .createEmployee(this.employee).subscribe(data => {
      console.log(data)
      this.employee = new Employee();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }
  

  gotoList() {
    this.router.navigate(['/']);
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
  clearForm()
  {
    (<HTMLFormElement>document.getElementById("employeeform")).reset();

  }
  btnClick()
  {
    this.router.navigateByUrl("/");
  }

}
