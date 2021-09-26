import { baseBudgetHandler } from "./base-budget-handler";
import { CustomerBudget } from "./customer-budget";

export class ManagerBudgetHandler extends baseBudgetHandler {
  handle(budget: CustomerBudget): CustomerBudget {
    if (budget.total <= 5000) {
      console.log('O gerente tratou o orçamento');
      budget.approved = true;
      return budget;
    }

    return super.handle(budget);
  }
}