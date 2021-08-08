import { Dessert } from './dessert';
import { Beverage } from './beverage';
import { ComposedMeal } from './composed-meal';
import { MealBuilderProtocol } from './../interfaces/meal-builder-protocol';
import { Rice } from './rice';
import { Beans } from './beans';

export class VeganDishBuilder implements MealBuilderProtocol {
  makeBeverage(): this {
    throw new Error('Method not implemented.');
  }
  private _meal: ComposedMeal = new ComposedMeal();

  reset(): this {
    this._meal = new ComposedMeal();
    return this;
  }

  makeMeal(): this {
    const rice = new Rice('Arroz', 50);
    const beans = new Beans('Feijão', 10);
    this._meal.add(rice, beans);
    return this;
  }

  makeDessert(): this {
    const dessert = new Dessert('Sobremesa', 10);
    this._meal.add(dessert);
    return this;
  }

  getMeal(): ComposedMeal {
    return this._meal;
  }

  getPrice(): number {
    return this._meal.getPrice();
  }
}
