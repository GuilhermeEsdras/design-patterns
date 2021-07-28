import { MyDatabaseClassic } from './db/my-database-classic';
import { myDatabaseClassic as myDatabaseClassicFromModuleA } from './module_a_classic';

const myDatabaseClassic = MyDatabaseClassic.instance;
myDatabaseClassic.add({ name: 'Fulano', age: 15 });
myDatabaseClassic.add({ name: 'Cicrano', age: 25 });
myDatabaseClassic.add({ name: 'Beltrano', age: 35 });
myDatabaseClassic.show();

console.log(myDatabaseClassic === myDatabaseClassicFromModuleA);
