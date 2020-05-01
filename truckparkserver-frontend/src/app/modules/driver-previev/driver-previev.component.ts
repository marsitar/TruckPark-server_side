import {Component, OnInit} from '@angular/core';
import {DriverService} from '../../service/driver.service';
import {Driver} from '../../domain/driver';
import {NzMessageService} from 'ng-zorro-antd/message';
import {NgForm} from '@angular/forms';
import {TruckService} from '../../service/truck.service';
import {Truck} from '../../domain/truck';
import {Router} from '@angular/router';
import {KeycloakService} from 'keycloak-angular';

@Component({
  selector: 'app-driver-previev',
  templateUrl: './driver-previev.component.html',
  styleUrls: ['./driver-previev.component.css'],
})
export class DriverPrevievComponent implements OnInit {

  drivers: Driver[] = [];
  trucks: Truck[] = [];
  isAddEditDriverModalVisible: boolean;
  isAddEditDriverProceeding: boolean;
  addEditDriverForm: Driver;
  isEditMode: boolean;
  sortKey: string;
  sortValue: string;

  constructor(
    private driverService: DriverService,
    private truckService: TruckService,
    private message: NzMessageService,
    protected router: Router,
    protected keycloakAngular: KeycloakService,
  ) {
    this.addEditDriverForm = new Driver();
    this.isAddEditDriverModalVisible = false;
    this.isAddEditDriverProceeding = false;
    this.isEditMode = false;
  }

  ngOnInit(): void {
    this.loadDrivers();
    this.loadTrucks();
  }

  private loadDrivers(){
    this.driverService.getAllDrivers().subscribe(drivers => {
      this.drivers = drivers;
      console.log(drivers);
      if(this.sortKey && this.sortKey) {
        this.sort({key: this.sortKey, value: this.sortKey});
      } else {
        this.sort({key: "id", value: "ascend"});
      }
    });
  }

  private loadTrucks(){
    this.truckService.getTrucks().subscribe( trucks =>
      {
        this.trucks = trucks;
        console.log('trucks: ', this.trucks);
      }
    )
  }

  sort(sort: { key: string; value: string }): void {

    this.sortKey = sort.key;
    this.sortValue = sort.value;

    this.drivers.sort((a, b) =>
      sort.value === 'ascend'
        ? a[sort.key] > b[sort.key!] ? 1 : -1
        : b[sort.key!] > a[sort.key!] ? 1 : -1
    );
  }

  handleDeleteDriver(driverId: number): void {
    console.log('deleteDriver(driverId= ',driverId,')');
    this.driverService.deleteDriver(driverId).subscribe( () =>
      {
        this.message.success('Kierowca id=${driverId} został usunięty');
        this.loadDrivers();
      },
      error => {
        this.message.error('Wystąpił błąd. Kierowca id=${driverId} nie został usunięty');
      }
    );
  }

  handleCancel(message: string): void {
    this.message.info(message);
  }

  editDriver(driverId: number): void {
    this.addEditDriverForm = this.drivers.find(driver => driver.id === driverId);
    console.log('To edit driver id', driverId);
    console.log('DriverToEdit ', this.addEditDriverForm);
    this.isEditMode = true;
    this.isAddEditDriverModalVisible = true;
  }

  addDriver(): void {
    this.isAddEditDriverModalVisible = true;
    this.isEditMode = false;
  }

  handleAddOrEditDriver(f: NgForm): void {
    if (this.isEditMode) {
      this.handleEditDriver(f);
    } else {
      this.handleAddDriver(f);
    }
  }

  handleAddDriver(f: NgForm): void {
    this.addEditDriverForm.companyId=1;
    console.log('handleAddDriver() ',this.addEditDriverForm);
    this.isAddEditDriverProceeding = true;
    this.driverService.addDriver(this.addEditDriverForm).subscribe( () =>
      {
        this.message.success('Dodano kierowcę');
        this.isAddEditDriverProceeding = false;
        this.isAddEditDriverModalVisible = false;
        this.addEditDriverForm = new Driver();
        this.loadDrivers();
      },
      error => {
        this.message.error('Wystąpił błąd. Nie dodano kierowcy');
        this.isAddEditDriverProceeding = false;
      }
    );
  }

  handleEditDriver(f: NgForm): void {
    this.addEditDriverForm.companyId=1;
    console.log('handleEditDriver() ',this.addEditDriverForm);
    this.isAddEditDriverProceeding = true;
    this.driverService.updateDriver(this.addEditDriverForm).subscribe(() =>
      {
        this.message.success('Kierowca został zaaktualizowany');
        this.isAddEditDriverProceeding = false;
        this.isAddEditDriverModalVisible = false;
        this.addEditDriverForm = new Driver();
        this.loadDrivers();
      },
      error => {
        this.message.error('Wystąpił błąd. Kierowca nie został zaaktualizowany');
        this.isAddEditDriverProceeding = false;
      }
    );
  }

  handleAddingDriverCancel(message: string): void {
    this.isAddEditDriverModalVisible = false;
    this.addEditDriverForm = new Driver();
    this.handleCancel(message);
  }

  driverDetails(driverId: number): void {
    console.log('Driver id= ', driverId, ' is to be previeved');
  }

  generateTruckLabel(truck: Truck): string {
    return ''.concat(truck.brand, ' ', truck.model, ' ',truck.registration);
  }

  generateModalTitle(): string {
    if(this.isEditMode){
      return 'Edytuj kierowcę';
    } else {
      return 'Dodaj kierowcę';
    }
  }
}
