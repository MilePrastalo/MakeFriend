import { Interest } from './Interest';

export class InterestCategory {
    constructor(public id: number, public name: string, public interests: Array<Interest>) { }
}
