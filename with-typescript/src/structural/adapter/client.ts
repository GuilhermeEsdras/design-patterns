import { emailValidatorFnAdapter } from './validation/email-validator-fn-adapter';
import { EmailValidatorClassAdapter } from './validation/email-validator-class-adapter';
import {
  EmailValidatorFnProtocol,
  EmailValidatorProtocol,
} from './validation/email-validator-protocol';

function validaEmailClass(
  emailValidator: EmailValidatorProtocol,
  email: string,
): void {
  if (emailValidator.isEmail(email)) {
    console.log('Email é válido (CLASS)');
  } else {
    console.log('Email é inválido (CLASS)');
  }
}

function validaEmailFn(
  emailValidator: EmailValidatorFnProtocol,
  email: string,
): void {
  if (emailValidator(email)) {
    console.log('Email é válido (FN)');
  } else {
    console.log('Email é inválido (FN)');
  }
}

const email = 'guilherme.esdras@outlook.com';
validaEmailClass(new EmailValidatorClassAdapter(), email);
validaEmailFn(emailValidatorFnAdapter, email);
