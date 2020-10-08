import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employeemain';


@Component({
  selector: 'app-modify-employee',
  templateUrl: './modify-employee.component.html',
  styleUrls: ['./modify-employee.component.css']
})
export class ModifyEmployeeComponent implements OnInit {
  id: number;
  employee: Employee;
  employees : Observable<Employee[]>;

  constructor(private route: ActivatedRoute,private router: Router,
    private employeeService: EmployeeService) { }

    ngOnInit()
    { 
      this.employee = new Employee();

      
}

  
  updateEmployee() {
    this.employeeService.updateEmployee(this.id, this.employee)
      .subscribe(data => {
        console.log(data);
        this.employee = new Employee();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/']);
  }









  showModal : boolean;
  showModal1 : boolean;
  showModal2 : boolean;
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
  onClick2(event)
  {
    this.showModal2 = true; // Show-Hide Modal Check
   
  }
  //Bootstrap Modal Close event
  hide2()
  {
    this.showModal2 = false;
  }

  

}
