import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employeemain';

@Component({
  selector: 'app-contentarea',
  templateUrl: './contentarea.component.html',
  styleUrls: ['./contentarea.component.css']
})
export class ContentareaComponent implements OnInit {

  employees : Observable<Employee[]>;

  constructor( private employeeService : EmployeeService  , private router : Router) { }

  ngOnInit() {
    this.reloadData();
  }
  reloadData() {
    this.employees = this.employeeService.getEmployeesList();
  }

  employeeDetails(id: number){
    this.router.navigate(['details', id]);
  }

}
