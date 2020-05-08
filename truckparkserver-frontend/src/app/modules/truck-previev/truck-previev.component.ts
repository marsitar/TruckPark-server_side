import {Component, OnInit} from '@angular/core';
import {Truck} from '../../domain/truck';
import {TruckService} from '../../service/truck.service';
import {NzMessageService} from 'ng-zorro-antd';
import {NgForm} from '@angular/forms';
import {KeycloakService} from 'keycloak-angular';
import {Router} from '@angular/router';
import {SecurityService} from '../../core/security.service';
import {TruckParkSystemRoles} from '../../core/truck-park-system-roles';

@Component({
  selector: 'app-truck-previev',
  templateUrl: './truck-previev.component.html',
  styleUrls: ['./truck-previev.component.css'],
})
export class TruckPrevievComponent implements OnInit {

  trucks: Truck[] = [];
  roles = TruckParkSystemRoles;
  isAddEditTruckModalVisible: boolean;
  isAddEditTruckProceeding: boolean;
  addEditTruckForm: Truck;
  isEditMode: boolean;
  sortKey: string;
  sortValue: string;

  constructor(
    private truckService: TruckService,
    private message: NzMessageService,
    protected router: Router,
    protected keycloakService: KeycloakService,
    public securityService: SecurityService
  ) {
    this.addEditTruckForm = new Truck();
    this.isAddEditTruckModalVisible = false;
    this.isAddEditTruckProceeding = false;
    this.isEditMode = false;
  }

  ngOnInit(): void {
    this.loadTrucks();
  }

  private loadTrucks(){
    this.truckService.getTrucks().subscribe( trucks => {
      this.trucks = trucks;
      console.log('trucks: ', this.trucks);
      if(this.sortKey && this.sortKey) {
        this.sort({key: this.sortKey, value: this.sortKey});
      } else {
        this.sort({key: "id", value: "ascend"});
      }
    });
  }

  sort(sort: { key: string; value: string }): void {

    this.sortKey = sort.key;
    this.sortValue = sort.value;

    this.trucks.sort((a, b) =>
      sort.value === 'ascend'
        ? a[sort.key] > b[sort.key!] ? 1 : -1
        : b[sort.key!] > a[sort.key!] ? 1 : -1
    );
  }

  handleDeleteTruck(truckId: number): void {
    console.log('deleteTruck(truckId= ',truckId,')');
    this.truckService.deleteTruck(truckId).subscribe( () =>
      {
        this.message.success('Pojazd id=${driverId} został usunięty');
        this.loadTrucks();
      },
      error => {
        this.message.error('Wystąpił błąd. Pojazd id=${driverId} nie został usunięty');
      }
    );
  }

  handleCancel(message: string): void {
    this.message.info(message);
  }

  editTruck(truckId: number): void {
    this.addEditTruckForm = this.trucks.find(truck => truck.id === truckId);
    console.log('To edit truck id', truckId);
    console.log('TruckToEdit ', this.addEditTruckForm);
    this.isEditMode = true;
    this.isAddEditTruckModalVisible = true;
  }

  addTruck(): void {
    this.isAddEditTruckModalVisible = true;
    this.isEditMode = false;
  }

  handleAddOrEditTruck(f: NgForm): void {
    if (this.isEditMode) {
      this.handleEditTruck(f);
    } else {
      this.handleAddTruck(f);
    }
  }

  handleAddTruck(f: NgForm): void {
    this.addEditTruckForm.companyId=1;
    console.log('handleAddTruck() ',this.addEditTruckForm);
    this.isAddEditTruckProceeding = true;
    this.truckService.addTruck(this.addEditTruckForm).subscribe( () =>
      {
        this.message.success('Dodano pojazd');
        this.isAddEditTruckProceeding = false;
        this.isAddEditTruckModalVisible = false;
        this.addEditTruckForm = new Truck();
        this.loadTrucks();
      },
      error => {
        this.message.error('Wystąpił błąd. Nie dodano pojazdu');
        this.isAddEditTruckProceeding = false;
      }
    );
  }

  handleEditTruck(f: NgForm): void {
    this.addEditTruckForm.companyId=1;
    console.log('handleEditTruck() ',this.addEditTruckForm);
    this.isAddEditTruckProceeding = true;
    this.truckService.updateTruck(this.addEditTruckForm).subscribe(() =>
      {
        this.message.success('Pojazd został zaaktualizowany');
        this.isAddEditTruckProceeding = false;
        this.isAddEditTruckModalVisible = false;
        this.addEditTruckForm = new Truck();
        this.loadTrucks();
      },
      error => {
        this.message.error('Wystąpił błąd. Pojazd nie został zaaktualizowany');
        this.isAddEditTruckProceeding = false;
      }
    );
  }

  handleAddingTruckCancel(message: string): void {
    this.isAddEditTruckModalVisible = false;
    this.addEditTruckForm = new Truck();
    this.handleCancel(message);
  }

  truckDetails(driverId: number): void {
    console.log('Truck id= ', driverId, ' is to be previeved');
  }

  generateModalTitle(): string {
    if(this.isEditMode){
      return 'Edytuj pojazd';
    } else {
      return 'Dodaj pojazd';
    }
  }

}
