import {Coordinate} from './coordinate';
import {ExtendedMopData} from './extended-mop-data';

export class Mop {
  id: number;
  identificationName: string;
  category: string;
  place: string;
  coordinate: Coordinate;
  roadNumber: string;
  truckPlaces: number;
  occupiedTruckPlaces: number;
  extendedId: string;
  extendedMopData: ExtendedMopData;
}
