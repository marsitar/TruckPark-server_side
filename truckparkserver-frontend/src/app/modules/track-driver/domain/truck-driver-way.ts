import {Coordinate} from '../../map/domain/coordinate';
import DateTimeFormat = Intl.DateTimeFormat;

export class TruckDriverWay {

  id: number;
  fuel: number;
  distance: number;
  resultTime: DateTimeFormat;
  coordinate: Coordinate;
  truckId: number;
  driverId: number;
}
