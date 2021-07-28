import { MyDatabaseModule } from './db/my-database-module';

const myDatabaseModule = MyDatabaseModule;
myDatabaseModule.add({ name: 'Guilherme', age: 10 });
myDatabaseModule.add({ name: 'Esdras', age: 20 });
myDatabaseModule.add({ name: 'GuiEsdras', age: 30 });
myDatabaseModule.show();

export { myDatabaseModule };
