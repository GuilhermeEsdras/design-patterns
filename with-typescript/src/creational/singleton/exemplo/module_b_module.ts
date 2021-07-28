import { MyDatabaseModule } from './db/my-database-module';
import { myDatabaseModule as MyDatabaseModuleFromModuleA } from './module_a_module';

const myDatabaseModule = MyDatabaseModule;
myDatabaseModule.add({ name: 'Fulano', age: 15 });
myDatabaseModule.add({ name: 'Cicrano', age: 25 });
myDatabaseModule.add({ name: 'Beltrano', age: 35 });
myDatabaseModule.show();

console.log(myDatabaseModule === MyDatabaseModuleFromModuleA);
