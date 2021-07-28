import { MyDatabaseFunction } from './db/my-database-function';
import { myDatabaseFunction as MyDatabaseFunctionFromModuleA } from './module_a_function';

const myDatabaseFunction = MyDatabaseFunction;
myDatabaseFunction.add({ name: 'Fulano', age: 15 });
myDatabaseFunction.add({ name: 'Cicrano', age: 25 });
myDatabaseFunction.add({ name: 'Beltrano', age: 35 });
myDatabaseFunction.show();

console.log(myDatabaseFunction === MyDatabaseFunctionFromModuleA);
