import { baseBudgetHandler } from './base-budget-handler';
import { CustomerBudget } from './customer-budget';

export class CEOBudgetHandler extends baseBudgetHandler {
  handle(budget: CustomerBudget): CustomerBudget {
    console.log('O CEO trata qualquer orçamento');
    budget.approved = true;
    return budget;
  }
}
