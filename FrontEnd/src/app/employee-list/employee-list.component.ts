import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee} from '../employeemain';
import { EmployeeService} from '../employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  

  ngOnInit(): void {
    
  }
  
}


