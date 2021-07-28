import { MyDatabaseClassic } from './db/my-database-classic';

const myDatabaseClassic = MyDatabaseClassic.instance;
myDatabaseClassic.add({ name: 'Guilherme', age: 10 });
myDatabaseClassic.add({ name: 'Esdras', age: 20 });
myDatabaseClassic.add({ name: 'GuiEsdras', age: 30 });
myDatabaseClassic.show();

export { myDatabaseClassic };
