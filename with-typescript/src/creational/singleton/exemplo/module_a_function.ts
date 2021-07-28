import { MyDatabaseFunction } from './db/my-database-function';

const myDatabaseFunction = MyDatabaseFunction;
myDatabaseFunction.add({ name: 'Guilherme', age: 10 });
myDatabaseFunction.add({ name: 'Esdras', age: 20 });
myDatabaseFunction.add({ name: 'GuiEsdras', age: 30 });
myDatabaseFunction.show();

export { myDatabaseFunction };
