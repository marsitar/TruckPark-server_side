import {Component, OnInit} from '@angular/core';
import {DriverService} from '../../service/driver.service';
import {Driver} from '../../domain/driver';

@Component({
  selector: 'app-driver-previev',
  templateUrl: './driver-previev.component.html',
  styleUrls: ['./driver-previev.component.css']
})
export class DriverPrevievComponent implements OnInit {

  drivers: Driver[] = [];

  constructor(
    private driverService: DriverService
  ) { }

  ngOnInit(): void {
    this.loadDrivers();
  }

  private loadDrivers(){
    this.driverService.getAllDrivers().subscribe(drivers => {
      this.drivers = drivers;
      this.sort({key: "id", value: "ascend"});
    });
  }

  sort(sort: { key: string; value: string }): void {
    this.drivers.sort((a, b) =>
      sort.value === 'ascend'
        ? a[sort.key] > b[sort.key!] ? 1 : -1
        : b[sort.key!] > a[sort.key!] ? 1 : -1
    );
  }

}
