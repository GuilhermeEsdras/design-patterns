import {CustomerBudget} from './customer-budget'

export abstract class baseBudgetHandler {
  protected nextHandler: baseBudgetHandler | null = null;

  setNextHandler(handler: baseBudgetHandler): baseBudgetHandler {
    this.nextHandler = handler;
    return handler;
  }

  handle(budget: CustomerBudget): CustomerBudget {
    if (this.nextHandler) return this.nextHandler.handle(budget);
    return budget;
  }
}